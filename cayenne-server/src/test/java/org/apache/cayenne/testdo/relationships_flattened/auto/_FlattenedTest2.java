package org.apache.cayenne.testdo.relationships_flattened.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.testdo.relationships_flattened.FlattenedTest1;
import org.apache.cayenne.testdo.relationships_flattened.FlattenedTest3;

import java.util.List;

/**
 * Class _FlattenedTest2 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FlattenedTest2 extends CayenneDataObject {

    public static final String NAME_PROPERTY = "name";
    public static final String FT3ARRAY_PROPERTY = "ft3Array";
    public static final String TO_FT1_PROPERTY = "toFT1";

    public static final String FT2_ID_PK_COLUMN = "FT2_ID";

    public void setName(String name) {
        writeProperty(NAME_PROPERTY, name);
    }
    public String getName() {
        return (String)readProperty(NAME_PROPERTY);
    }

    public void addToFt3Array(FlattenedTest3 obj) {
        addToManyTarget(FT3ARRAY_PROPERTY, obj, true);
    }
    public void removeFromFt3Array(FlattenedTest3 obj) {
        removeToManyTarget(FT3ARRAY_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<FlattenedTest3> getFt3Array() {
        return (List<FlattenedTest3>)readProperty(FT3ARRAY_PROPERTY);
    }


    public void setToFT1(FlattenedTest1 toFT1) {
        setToOneTarget(TO_FT1_PROPERTY, toFT1, true);
    }

    public FlattenedTest1 getToFT1() {
        return (FlattenedTest1)readProperty(TO_FT1_PROPERTY);
    }


}
