import gov.va.vinci.leo.listener.SimpleCsvListener

String csvDir =  "src/test/output/ABI_output.csv"
if(!(new File(csvDir)).exists()) (new File(csvDir).getParentFile()).mkdirs()

listener = new SimpleCsvListener(new File(csvDir))

listener.setInputType("gov.va.vinci.abi.types.Logic")
listener.setIncludeHeader(true)
listener.setIncludeFeatures(true)