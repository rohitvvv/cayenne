package org.apache.cayenne.testdo.inheritance.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.testdo.inheritance.BaseEntity;
import org.apache.cayenne.testdo.inheritance.SubEntity;

import java.util.List;

/**
 * Class _RelatedEntity was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _RelatedEntity extends CayenneDataObject {

    public static final String BASE_ENTITIES_PROPERTY = "baseEntities";
    public static final String SUB_ENTITIES_PROPERTY = "subEntities";

    public static final String RELATED_ENTITY_ID_PK_COLUMN = "RELATED_ENTITY_ID";

    public void addToBaseEntities(BaseEntity obj) {
        addToManyTarget(BASE_ENTITIES_PROPERTY, obj, true);
    }
    public void removeFromBaseEntities(BaseEntity obj) {
        removeToManyTarget(BASE_ENTITIES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<BaseEntity> getBaseEntities() {
        return (List<BaseEntity>)readProperty(BASE_ENTITIES_PROPERTY);
    }


    public void addToSubEntities(SubEntity obj) {
        addToManyTarget(SUB_ENTITIES_PROPERTY, obj, true);
    }
    public void removeFromSubEntities(SubEntity obj) {
        removeToManyTarget(SUB_ENTITIES_PROPERTY, obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<SubEntity> getSubEntities() {
        return (List<SubEntity>)readProperty(SUB_ENTITIES_PROPERTY);
    }


}
