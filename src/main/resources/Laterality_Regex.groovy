import gov.va.vinci.leo.regex.types.RegularExpressionType

/* An arbitrary name for this annotator. Used in the pipeline for the name of this annotation. */
name = "MyRegexAnnotator"

configuration {
    /* All configuration for this annotator. */
    defaults {
        /* Global for all configrations below if a property specified here is not overridden in a section below. */
        //String[] inputTypes = [Window.class.getCanonicalName()]
        outputType = RegularExpressionType.class.canonicalName
        case_sensitive = false
        matchedPatternFeatureName = "pattern"
        concept_feature_name = "concept"
        groupFeatureName = "group"
    }

    /* An arbitrary name for this set of patterns/config. */

    "Right" {
        expressions = [
                'right(:|-|\\.|~|;|\\b|\\.:)'
                ,'(?<=(\\d|\\b))r(:|-|\\.|~|;|\\b|\\)|:|p|d)'
                ,'\\(r\\)'
                ,'\\brt(:|-|\\.|~|;|\\b|\\.:)'
                ,'on\\s*the\\s*right'
                ,'(the\\s*)?right\\s*lower\\s*extremity'
                ,'rle(:|-|\\.|~|;|\\b|\\.:)'
                ,'#right\\s*arm'
                ,'#rt\\.?\\s*arm'
                ,'right\\.?\\s*ankle'
                ,'rt\\.?\\s*ankle'
                ,'\\(r\\)\\s*ankle'
                ,'right-sided'
                ,'rt-sided'
                ,'right\\s*foot'
                ,'right\\s*value'
                ,'right\\s*leg'
                ,'R\\)(:|-|\\.|~|;|\\b|\\.:)'
                ,'rdp'
                ,'rpt'
           ]

        concept_feature_value = "Right"
        outputType = "gov.va.vinci.abi.types.Laterality"
    }



    "abi-left" {
        expressions = [
                'left(:|-|\\.|~|;|\\b)',
                '(?<=(\\d|\\b))l(:|-|\\.|~|;|\\b|\\.:|\\)|p|d)',
                '\\(l\\)',
                'LLE(:|-|\\.|~|;|\\b)',
                'on\\s*the\\s*left',
                '\\blt(:|-|\\.|~|;|\\b|\\.:)',
                '(the\\s*)?left\\s*lower\\s*extremity',
                '#left\\s*arm',
                '#lt\\.?\\s*arm',
                'left\\.?\\s*ankle',
                'lt\\.?\\s*ankle',
                '\\(l\\)\\s*ankle',
                'left-sided',
                'lt\\.?-sided',
                'left\\s*foot',
                'left\\s*value',
                'left\\s*leg',
                'ldp',
                'lpt'
        ]

        concept_feature_value = "Left"
        outputType = "gov.va.vinci.abi.types.Laterality"
    }

    "abi-Bilateral" {
        expressions = [
                'bilateral(ly)?'
                ,'b/l'
                ,'both\\s*extremities'
                ,'right\\s*and\\s*left'
                ,'right\\s*and\\s*left\\s*ankle'
                ,'b\\/l'
                ,'both\\s*sides'
        ]

        concept_feature_value = "Bilateral"
        outputType = "gov.va.vinci.abi.types.Laterality"
    }

    "Template" {
        //Messy Logic, sets first instance in a table to Right, second instance gets manually set to Left
        expressions = [
               'Right\\s*Left',
                'R\\s*L\\b',
                '\\(right,\\s*left\\)'
        ]

        concept_feature_value = "Right"
        outputType = "gov.va.vinci.abi.types.Laterality"
    }



}

