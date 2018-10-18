import gov.va.vinci.knowtator.model.KnowtatorToUimaTypeMap

String outputDir = "<Path to output directory>"
String outputWorkspaceName = "outputWorkspaceName"
boolean writeFilteredFilesOnly = false; // if false, all documents will be written out. If true, only relevant documents will be written out.

def knowtatorToUimaTypeMap = { ->
    KnowtatorToUimaTypeMap map = new KnowtatorToUimaTypeMap();
    /*    Prior to this, you have to add the UIMA types system*/
    //  map.addAnnotationTypeMap(knowtator annotation type, UIMA annotation type )
    // map.addFeatureTypeMap(knowtatorAnnotation, knowtatorAttribute, UIMA_feature);

    map.addAnnotationTypeMap("Index", "gov.va.vinci.abi.types.Logic");
    map.addFeatureTypeMap("Index", "ABI_Value", "ABI_Value");
    map.addFeatureTypeMap("Index", "Index_Type", "Index_Type");
    map.addFeatureTypeMap("Index", "Laterality_Value", "Laterality_Value");
    return map;

}

listener = new gov.va.vinci.knowtator.listener.KnowtatorListener(outputWorkspaceName, outputDir, outputDir, knowtatorToUimaTypeMap());

if(writeFilteredFilesOnly)  listener.setAnnotationTypeFilter("gov.va.vinci.abi.types.Logic")