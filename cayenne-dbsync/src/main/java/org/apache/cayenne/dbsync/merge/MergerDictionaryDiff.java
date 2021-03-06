/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

package org.apache.cayenne.dbsync.merge;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MergerDictionaryDiff<T> {

    private List<MergerDiffPair<T>> same = new LinkedList<>();
    private List<MergerDiffPair<T>> missing = new LinkedList<>();

    MergerDictionaryDiff() {
    }

    public List<MergerDiffPair<T>> getSame() {
        return same;
    }

    public List<MergerDiffPair<T>> getMissing() {
        return missing;
    }

    public void addAll(MergerDictionaryDiff<T> other) {
        same.addAll(other.getSame());
        missing.addAll(other.getMissing());
    }

    static class Builder<T> {
        private MergerDictionaryDiff<T> diff;
        private MergerDictionary<T> originalDictionary;
        private MergerDictionary<T> importedDictionary;

        Builder() {
            diff = new MergerDictionaryDiff<>();
        }

        Builder<T> originalDictionary(MergerDictionary<T> dictionary) {
            this.originalDictionary = dictionary;
            return this;
        }

        Builder<T> importedDictionary(MergerDictionary<T> dictionary) {
            this.importedDictionary = dictionary;
            return this;
        }

        MergerDictionaryDiff<T> build() {
            if(originalDictionary == null || importedDictionary == null) {
                throw new IllegalArgumentException("Dictionaries not set");
            }

            originalDictionary.init();
            importedDictionary.init();

            diff.same = buildSame();
            diff.missing = buildMissing();

            return diff;
        }

        private List<MergerDiffPair<T>> buildSame() {
            List<MergerDiffPair<T>> sameEntities = new LinkedList<>();
            List<String> sameNames = new LinkedList<>();
            for(Map.Entry<String, T> entry : originalDictionary.getDictionary().entrySet()) {
                String name = entry.getKey();
                T original = entry.getValue();
                T imported = importedDictionary.getByName(name);
                if(imported != null) {
                    MergerDiffPair<T> pair = new MergerDiffPair<>(original, imported);
                    sameEntities.add(pair);
                    sameNames.add(name);
                }
            }

            // clean up found names
            for(String name : sameNames) {
                originalDictionary.remove(name);
                importedDictionary.remove(name);
            }

            return sameEntities;
        }

        private List<MergerDiffPair<T>> buildMissing() {
            List<MergerDiffPair<T>> missingEntities = new LinkedList<>();
            for(T original : originalDictionary.getDictionary().values()) {
                MergerDiffPair<T> pair = new MergerDiffPair<>(original, null);
                missingEntities.add(pair);
            }
            for(T imported : importedDictionary.getDictionary().values()) {
                MergerDiffPair<T> pair = new MergerDiffPair<>(null, imported);
                missingEntities.add(pair);
            }
            return missingEntities;
        }
    }

}
