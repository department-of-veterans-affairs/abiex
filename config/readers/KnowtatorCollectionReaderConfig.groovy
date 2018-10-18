import gov.va.vinci.knowtator.cr.KnowtatorCollectionReader
import gov.va.vinci.knowtator.model.KnowtatorToUimaTypeMap;

def knowtatorToUimaTypeMap = {
  ->
  KnowtatorToUimaTypeMap map = new KnowtatorToUimaTypeMap();
  // knowtatorAnnotation : UIMA annotation
  map.addAnnotationTypeMap("Current",          "gov.va.vinci.leo.types.RefSt_Current")
  map.addAnnotationTypeMap("Past",             "gov.va.vinci.leo.types.RefSt_Past")
  map.addAnnotationTypeMap("Non-Drinker",      "gov.va.vinci.leo.types.RefSt_Nondrinker" )
  map.addAnnotationTypeMap("DocumentReviewed", "gov.va.vinci.leo.types.Other")
  
  // map.addFeatureTypeMap("KnowtatorType", "KnowtatorFeature","UimaAnnotationFeature")
  
  return map
}

knowtatorCorpusPath ="C:\\Users\\Administrator\\Desktop\\eHOST_Project\\Project\\corpus\\"

knowtatorXmlPath = "C:\\Users\\Administrator\\Desktop\\eHOST_Project\\Project\\saved\\"

reader = new KnowtatorCollectionReader(new File(knowtatorCorpusPath), new File(knowtatorXmlPath), knowtatorToUimaTypeMap(), true).produceCollectionReader()














