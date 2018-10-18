import gov.va.vinci.leo.listener.SimpleXmiListener

String xmiDir = "src/test/output/xmi"
boolean writeFilteredFilesOnly = false; // if false, all documents will be written out. If true, only relevant documents will be written out.

if(!(new File(xmiDir)).exists()) (new File(xmiDir)).mkdirs()
listener = new SimpleXmiListener(new File(xmiDir))

listener.setLaunchAnnotationViewer(true)  // if true, a Viewer will be displayed after processing
if(writeFilteredFilesOnly)  listener.setAnnotationTypeFilter("gov.va.vinci.abi.types.Logic")

