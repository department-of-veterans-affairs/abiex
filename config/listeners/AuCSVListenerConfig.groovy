package listeners

import gov.va.vinci.leo.aucompare.comparators.SpanAuComparator
import gov.va.vinci.leo.aucompare.listener.AuCompareCSVListener

HashMap auMap=["gov.va.vinci.leo.types.ReferenceStandardAnnotation"   :"gov.va.vinci.leo.types.SystemAnnotation"]

String outPath =  "data/output/auCompare.csv"
if(!(new File(outPath).getParentFile()).exists()) (new File(outPath)).mkdirs()

listener = new AuCompareCSVListener(new File (outPath), new SpanAuComparator(auMap, true));
