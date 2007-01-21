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

package org.apache.cayenne.graph;

/**
 * An abstract superclass of operations on individual nodes and arcs in a digraph.
 * 
 * @since 1.2
 * @author Andrus Adamchik
 */
public abstract class NodeDiff implements GraphDiff, Comparable {

    protected int diffId;
    protected Object nodeId;

    public NodeDiff(Object nodeId) {
        this.nodeId = nodeId;
    }

    public NodeDiff(Object nodeId, int diffId) {
        this.nodeId = nodeId;
        this.diffId = diffId;
    }

    public boolean isNoop() {
        return false;
    }

    public abstract void apply(GraphChangeHandler tracker);

    public abstract void undo(GraphChangeHandler tracker);

    public Object getNodeId() {
        return nodeId;
    }

    /**
     * Returns an id of this diff that can be used for various purposes, such as
     * identifying the order of the diff in a sequence.
     */
    public int getDiffId() {
        return diffId;
    }

    /**
     * Sets an id of this diff that can be used for various purposes, such as identifying
     * the order of the diff in a sequence.
     */
    public void setDiffId(int diffId) {
        this.diffId = diffId;
    }

    /**
     * Implements a Comparable interface method to compare based on diffId property.
     */
    public int compareTo(Object o) {
        if (!(o instanceof NodeDiff)) {
            throw new IllegalArgumentException("Can't compare to " + o);
        }

        return diffId - ((NodeDiff) o).getDiffId();
    }
}
