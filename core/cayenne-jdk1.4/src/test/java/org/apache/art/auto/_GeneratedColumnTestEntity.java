package org.apache.art.auto;

/** Class _GeneratedColumnTestEntity was generated by Cayenne.
  * It is probably a good idea to avoid changing this class manually, 
  * since it may be overwritten next time code is regenerated. 
  * If you need to make any customizations, please use subclass. 
  */
public class _GeneratedColumnTestEntity extends org.apache.cayenne.CayenneDataObject {

    public static final String NAME_PROPERTY = "name";
    public static final String TO_DEP_PROPERTY = "toDep";

    public static final String GENERATED_COLUMN_PK_COLUMN = "GENERATED_COLUMN";

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }
    
    
    public void setToDep(org.apache.art.GeneratedColumnDep toDep) {
        setToOneTarget("toDep", toDep, true);
    }

    public org.apache.art.GeneratedColumnDep getToDep() {
        return (org.apache.art.GeneratedColumnDep)readProperty("toDep");
    } 
    
    
}
