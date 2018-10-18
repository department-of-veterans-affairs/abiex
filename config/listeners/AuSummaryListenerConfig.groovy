package listeners

import gov.va.vinci.leo.aucompare.comparators.SpanAuComparator
import gov.va.vinci.leo.aucompare.listener.AuSummaryListener;

auMap=["gov.va.vinci.leo.types.ReferenceStandardAnnotation"   :"gov.va.vinci.leo.types.SystemAnnotation"]

listener = new AuSummaryListener(new SpanAuComparator(auMap, true));
