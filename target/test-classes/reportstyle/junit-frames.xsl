<!--<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"-->
    <!--xmlns:lxslt="http://xml.apache.org/xslt"-->
    <!--xmlns:redirect="http://xml.apache.org/xalan/redirect"-->
    <!--xmlns:stringutils="xalan://org.apache.tools.ant.util.StringUtils"-->
    <!--extension-element-prefixes="redirect">-->
<!--<xsl:output method="html" indent="yes" encoding="US-ASCII"/>-->
<!--<xsl:decimal-format decimal-separator="." grouping-separator=","/>-->
<!--&lt;!&ndash;-->
<!--Copyright 2001-2004 The Apache Software Foundation.-->

<!--Licensed under the Apache License, Version 2.0 (the "License");-->
<!--you may not use this file except in compliance with the License.-->
<!--You may obtain a copy of the License at-->

     <!--http://www.apache.org/licenses/LICENSE-2.0-->

<!--Unless required by applicable law or agreed to in writing, software-->
<!--distributed under the License is distributed on an "AS IS" BASIS,-->
<!--WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.-->
<!--See the License for the specific language governing permissions and-->
<!--limitations under the License.-->
 <!--&ndash;&gt;-->

<!--&lt;!&ndash;-->

 <!--Sample stylesheet to be used with An JUnitReport output.-->

 <!--It creates a set of HTML files a la javadoc where you can browse easily-->
 <!--through all packages and classes.-->

 <!--@author Stephane Bailliez <a href="mailto:sbailliez@apache.org"/>-->
 <!--@author Erik Hatcher <a href="mailto:ehatcher@apache.org"/>-->
 <!--@author Martijn Kruithof <a href="mailto:martijn@kruithof.xs4all.nl"/>-->

<!--&ndash;&gt;-->
<!--<xsl:param name="output.dir" select="'.'"/>-->


<!--<xsl:template match="testsuites">-->
    <!--&lt;!&ndash; create the index.html &ndash;&gt;-->
    <!--<redirect:write file="{$output.dir}/index.html">-->
        <!--<xsl:call-template name="index.html"/>-->
    <!--</redirect:write>-->

    <!--&lt;!&ndash; create the stylesheet.css &ndash;&gt;-->
    <!--<redirect:write file="{$output.dir}/stylesheet.css">-->
        <!--<xsl:call-template name="stylesheet.css"/>-->
    <!--</redirect:write>-->

    <!--&lt;!&ndash; create the overview-packages.html at the root &ndash;&gt;-->
    <!--<redirect:write file="{$output.dir}/overview-summary.html">-->
        <!--<xsl:apply-templates select="." mode="overview.packages"/>-->
    <!--</redirect:write>-->

    <!--&lt;!&ndash; create the all-packages.html at the root &ndash;&gt;-->
    <!--<redirect:write file="{$output.dir}/overview-frame.html">-->
        <!--<xsl:apply-templates select="." mode="all.packages"/>-->
    <!--</redirect:write>-->

    <!--&lt;!&ndash; create the all-classes.html at the root &ndash;&gt;-->
    <!--<redirect:write file="{$output.dir}/allclasses-frame.html">-->
        <!--<xsl:apply-templates select="." mode="all.classes"/>-->
    <!--</redirect:write>-->

    <!--&lt;!&ndash; process all packages &ndash;&gt;-->
    <!--<xsl:for-each select="./testsuite[not(./@package = preceding-sibling::testsuite/@package)]">-->
        <!--<xsl:call-template name="package">-->
            <!--<xsl:with-param name="name" select="@package"/>-->
        <!--</xsl:call-template>-->
    <!--</xsl:for-each>-->
<!--</xsl:template>-->


<!--<xsl:template name="package">-->
    <!--<xsl:param name="name"/>-->
    <!--<xsl:variable name="package.dir">-->
        <!--<xsl:if test="not($name = '')"><xsl:value-of select="translate($name,'.','/')"/></xsl:if>-->
        <!--<xsl:if test="$name = ''">.</xsl:if>-->
    <!--</xsl:variable>-->
    <!--&lt;!&ndash;Processing package <xsl:value-of select="@name"/> in <xsl:value-of select="$output.dir"/> &ndash;&gt;-->
    <!--&lt;!&ndash; create a classes-list.html in the package directory &ndash;&gt;-->
    <!--<redirect:write file="{$output.dir}/{$package.dir}/package-frame.html">-->
        <!--<xsl:call-template name="classes.list">-->
            <!--<xsl:with-param name="name" select="$name"/>-->
        <!--</xsl:call-template>-->
    <!--</redirect:write>-->

    <!--&lt;!&ndash; create a package-summary.html in the package directory &ndash;&gt;-->
    <!--<redirect:write file="{$output.dir}/{$package.dir}/package-summary.html">-->
        <!--<xsl:call-template name="package.summary">-->
            <!--<xsl:with-param name="name" select="$name"/>-->
        <!--</xsl:call-template>-->
    <!--</redirect:write>-->

    <!--&lt;!&ndash; for each class, creates a @name.html &ndash;&gt;-->
    <!--&lt;!&ndash; @bug there will be a problem with inner classes having the same name, it will be overwritten &ndash;&gt;-->
    <!--<xsl:for-each select="/testsuites/testsuite[@package = $name]">-->
        <!--<redirect:write file="{$output.dir}/{$package.dir}/{@name}.html">-->
            <!--<xsl:apply-templates select="." mode="class.details"/>-->
        <!--</redirect:write>-->
        <!--<xsl:if test="string-length(./system-out)!=0">-->
            <!--<redirect:write file="{$output.dir}/{$package.dir}/{@name}-out.txt">-->
                <!--<xsl:value-of select="./system-out" />-->
            <!--</redirect:write>-->
        <!--</xsl:if>-->
        <!--<xsl:if test="string-length(./system-err)!=0">-->
            <!--<redirect:write file="{$output.dir}/{$package.dir}/{@name}-err.txt">-->
                <!--<xsl:value-of select="./system-err" />-->
            <!--</redirect:write>-->
        <!--</xsl:if>-->
    <!--</xsl:for-each>-->
<!--</xsl:template>-->

<!--<xsl:template name="index.html">-->
<!--<html>-->
    <!--<head>-->
        <!--<title>Unit Test Results.</title>-->
    <!--</head>-->
    <!--<frameset cols="20%,80%">-->
        <!--<frameset rows="30%,70%">-->
            <!--<frame src="overview-frame.html" name="packageListFrame"/>-->
            <!--<frame src="allclasses-frame.html" name="classListFrame"/>-->
        <!--</frameset>-->
        <!--<frame src="overview-summary.html" name="classFrame"/>-->
        <!--<noframes>-->
            <!--<h2>Frame Alert</h2>-->
            <!--<p>-->
                <!--This document is designed to be viewed using the frames feature. If you see this message, you are using a non-frame-capable web client.-->
            <!--</p>-->
        <!--</noframes>-->
    <!--</frameset>-->
<!--</html>-->
<!--</xsl:template>-->

<!--&lt;!&ndash; this is the stylesheet css to use for nearly everything &ndash;&gt;-->
<!--<xsl:template name="stylesheet.css">-->
<!--body {-->
    <!--font:normal 68% verdana,arial,helvetica;-->
    <!--color:#000000;-->
<!--}-->
<!--table tr td, table tr th {-->
    <!--font-size: 68%;-->
<!--}-->
<!--table.details tr th{-->
    <!--font-weight: bold;-->
    <!--text-align:left;-->
    <!--background:#a6caf0;-->
<!--}-->
<!--table.details tr td{-->
    <!--background:#eeeee0;-->
<!--}-->

<!--p {-->
    <!--line-height:1.5em;-->
    <!--margin-top:0.5em; margin-bottom:1.0em;-->
<!--}-->
<!--h1 {-->
    <!--margin: 0px 0px 5px; font: 165% verdana,arial,helvetica-->
<!--}-->
<!--h2 {-->
    <!--margin-top: 1em; margin-bottom: 0.5em; font: bold 125% verdana,arial,helvetica-->
<!--}-->
<!--h3 {-->
    <!--margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica-->
<!--}-->
<!--h4 {-->
    <!--margin-bottom: 0.5em; font: bold 100% verdana,arial,helvetica-->
<!--}-->
<!--h5 {-->
    <!--margin-bottom: 0.5em; font: bold 100% verdana,arial,helvetica-->
<!--}-->
<!--h6 {-->
    <!--margin-bottom: 0.5em; font: bold 100% verdana,arial,helvetica-->
<!--}-->
<!--.Error {-->
    <!--font-weight:bold; color:red;-->
<!--}-->
<!--.Failure {-->
    <!--font-weight:bold; color:purple;-->
<!--}-->
<!--.Properties {-->
  <!--text-align:right;-->
<!--}-->
<!--</xsl:template>-->


<!--&lt;!&ndash; ======================================================================-->
    <!--This page is created for every testsuite class.-->
    <!--It prints a summary of the testsuite and detailed information about-->
    <!--testcase methods.-->
     <!--====================================================================== &ndash;&gt;-->
<!--<xsl:template match="testsuite" mode="class.details">-->
    <!--<xsl:variable name="package.name" select="@package"/>-->
    <!--<xsl:variable name="class.name"><xsl:if test="not($package.name = '')"><xsl:value-of select="$package.name"/>.</xsl:if><xsl:value-of select="@name"/></xsl:variable>-->
    <!--<html>-->
        <!--<head>-->
          <!--<title>Unit Test Results: <xsl:value-of select="$class.name"/></title>-->
            <!--<xsl:call-template name="create.stylesheet.link">-->
                <!--<xsl:with-param name="package.name" select="$package.name"/>-->
            <!--</xsl:call-template>-->
       <!--<script type="text/javascript" language="JavaScript">-->
        <!--var TestCases = new Array();-->
        <!--var cur;-->
        <!--<xsl:apply-templates select="properties"/>-->
       <!--</script>-->
       <!--<script type="text/javascript" language="JavaScript"><![CDATA[-->
        <!--function displayProperties (name) {-->
          <!--var win = window.open('','JUnitSystemProperties','scrollbars=1,resizable=1');-->
          <!--var doc = win.document.open();-->
          <!--doc.write("<html><head><title>Properties of " + name + "</title>");-->
          <!--doc.write("<style type=\"text/css\">");-->
          <!--doc.write("body {font:normal 68% verdana,arial,helvetica; color:#000000; }");-->
          <!--doc.write("table tr td, table tr th { font-size: 68%; }");-->
          <!--doc.write("table.properties { border-collapse:collapse; border-left:solid 1 #cccccc; border-top:solid 1 #cccccc; padding:5px; }");-->
          <!--doc.write("table.properties th { text-align:left; border-right:solid 1 #cccccc; border-bottom:solid 1 #cccccc; background-color:#eeeeee; }");-->
          <!--doc.write("table.properties td { font:normal; text-align:left; border-right:solid 1 #cccccc; border-bottom:solid 1 #cccccc; background-color:#fffffff; }");-->
          <!--doc.write("h3 { margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica }");-->
          <!--doc.write("</style>");-->
          <!--doc.write("</head><body>");-->
          <!--doc.write("<h3>Properties of " + name + "</h3>");-->
          <!--doc.write("<div align=\"right\"><a href=\"javascript:window.close();\">Close</a></div>");-->
          <!--doc.write("<table class='properties'>");-->
          <!--doc.write("<tr><th>Name</th><th>Value</th></tr>");-->
          <!--for (prop in TestCases[name]) {-->
            <!--doc.write("<tr><th>" + prop + "</th><td>" + TestCases[name][prop] + "</td></tr>");-->
          <!--}-->
          <!--doc.write("</table>");-->
          <!--doc.write("</body></html>");-->
          <!--doc.close();-->
          <!--win.focus();-->
        <!--}-->
      <!--]]>-->
      <!--</script>-->
        <!--</head>-->
        <!--<body>-->
            <!--<xsl:call-template name="pageHeader"/>-->
            <!--<h3>Class <xsl:value-of select="$class.name"/></h3>-->


            <!--<table class="details" border="0" cellpadding="5" cellspacing="2" width="95%">-->
                <!--<xsl:call-template name="testsuite.test.header"/>-->
                <!--<xsl:apply-templates select="." mode="print.test"/>-->
            <!--</table>-->

            <!--<h2>Tests</h2>-->
            <!--<table class="details" border="0" cellpadding="5" cellspacing="2" width="95%">-->
        <!--<xsl:call-template name="testcase.test.header"/>-->
              <!--&lt;!&ndash;-->
              <!--test can even not be started at all (failure to load the class)-->
              <!--so report the error directly-->
              <!--&ndash;&gt;-->
                <!--<xsl:if test="./error">-->
                    <!--<tr class="Error">-->
                        <!--<td colspan="4"><xsl:apply-templates select="./error"/></td>-->
                    <!--</tr>-->
                <!--</xsl:if>-->
                <!--<xsl:apply-templates select="./testcase" mode="print.test"/>-->
            <!--</table>-->
            <!--<div class="Properties">-->
                <!--<a>-->
                    <!--<xsl:attribute name="href">javascript:displayProperties('<xsl:value-of select="@package"/>.<xsl:value-of select="@name"/>');</xsl:attribute>-->
                    <!--Properties &#187;-->
                <!--</a>-->
            <!--</div>-->
            <!--<xsl:if test="string-length(./system-out)!=0">-->
                <!--<div class="Properties">-->
                    <!--<a>-->
                        <!--<xsl:attribute name="href">./<xsl:value-of select="@name"/>-out.txt</xsl:attribute>-->
                        <!--System.out &#187;-->
                    <!--</a>-->
                <!--</div>-->
            <!--</xsl:if>-->
            <!--<xsl:if test="string-length(./system-err)!=0">-->
                <!--<div class="Properties">-->
                    <!--<a>-->
                        <!--<xsl:attribute name="href">./<xsl:value-of select="@name"/>-err.txt</xsl:attribute>-->
                        <!--System.err &#187;-->
                    <!--</a>-->
                <!--</div>-->
            <!--</xsl:if>-->
        <!--</body>-->
    <!--</html>-->
<!--</xsl:template>-->

  <!--&lt;!&ndash;-->
   <!--Write properties into a JavaScript data structure.-->
   <!--This is based on the original idea by Erik Hatcher (ehatcher@apache.org)-->
   <!--&ndash;&gt;-->
  <!--<xsl:template match="properties">-->
    <!--cur = TestCases['<xsl:value-of select="../@package"/>.<xsl:value-of select="../@name"/>'] = new Array();-->
    <!--<xsl:for-each select="property">-->
    <!--<xsl:sort select="@name"/>-->
        <!--cur['<xsl:value-of select="@name"/>'] = '<xsl:call-template name="JS-escape"><xsl:with-param name="string" select="@value"/></xsl:call-template>';-->
    <!--</xsl:for-each>-->
  <!--</xsl:template>-->


<!--&lt;!&ndash; ======================================================================-->
    <!--This page is created for every package.-->
    <!--It prints the name of all classes that belongs to this package.-->
    <!--@param name the package name to print classes.-->
     <!--====================================================================== &ndash;&gt;-->
<!--&lt;!&ndash; list of classes in a package &ndash;&gt;-->
<!--<xsl:template name="classes.list">-->
    <!--<xsl:param name="name"/>-->
    <!--<html>-->
        <!--<head>-->
            <!--<title>Unit Test Classes: <xsl:value-of select="$name"/></title>-->
            <!--<xsl:call-template name="create.stylesheet.link">-->
                <!--<xsl:with-param name="package.name" select="$name"/>-->
            <!--</xsl:call-template>-->
        <!--</head>-->
        <!--<body>-->
            <!--<table width="100%">-->
                <!--<tr>-->
                    <!--<td nowrap="nowrap">-->
                        <!--<h2><a href="package-summary.html" target="classFrame">-->
                            <!--<xsl:value-of select="$name"/>-->
                            <!--<xsl:if test="$name = ''">&lt;none&gt;</xsl:if>-->
                        <!--</a></h2>-->
                    <!--</td>-->
                <!--</tr>-->
            <!--</table>-->

            <!--<h2>Classes</h2>-->
            <!--<table width="100%">-->
                <!--<xsl:for-each select="/testsuites/testsuite[./@package = $name]">-->
                    <!--<xsl:sort select="@name"/>-->
                    <!--<tr>-->
                        <!--<td nowrap="nowrap">-->
                            <!--<a href="{@name}.html" target="classFrame"><xsl:value-of select="@name"/></a>-->
                        <!--</td>-->
                    <!--</tr>-->
                <!--</xsl:for-each>-->
            <!--</table>-->
        <!--</body>-->
    <!--</html>-->
<!--</xsl:template>-->


<!--&lt;!&ndash;-->
    <!--Creates an all-classes.html file that contains a link to all package-summary.html-->
    <!--on each class.-->
<!--&ndash;&gt;-->
<!--<xsl:template match="testsuites" mode="all.classes">-->
    <!--<html>-->
        <!--<head>-->
            <!--<title>All Unit Test Classes</title>-->
            <!--<xsl:call-template name="create.stylesheet.link">-->
                <!--<xsl:with-param name="package.name"/>-->
            <!--</xsl:call-template>-->
        <!--</head>-->
        <!--<body>-->
            <!--<h2>Classes</h2>-->
            <!--<table width="100%">-->
                <!--<xsl:apply-templates select="testsuite" mode="all.classes">-->
                    <!--<xsl:sort select="@name"/>-->
                <!--</xsl:apply-templates>-->
            <!--</table>-->
        <!--</body>-->
    <!--</html>-->
<!--</xsl:template>-->

<!--<xsl:template match="testsuite" mode="all.classes">-->
    <!--<xsl:variable name="package.name" select="@package"/>-->
    <!--<tr>-->
        <!--<td nowrap="nowrap">-->
            <!--<a target="classFrame">-->
                <!--<xsl:attribute name="href">-->
                    <!--<xsl:if test="not($package.name='')">-->
                        <!--<xsl:value-of select="translate($package.name,'.','/')"/><xsl:text>/</xsl:text>-->
                    <!--</xsl:if><xsl:value-of select="@name"/><xsl:text>.html</xsl:text>-->
                <!--</xsl:attribute>-->
                <!--<xsl:value-of select="@name"/>-->
            <!--</a>-->
        <!--</td>-->
    <!--</tr>-->
<!--</xsl:template>-->


<!--&lt;!&ndash;-->
    <!--Creates an html file that contains a link to all package-summary.html files on-->
    <!--each package existing on testsuites.-->
    <!--@bug there will be a problem here, I don't know yet how to handle unnamed package :(-->
<!--&ndash;&gt;-->
<!--<xsl:template match="testsuites" mode="all.packages">-->
    <!--<html>-->
        <!--<head>-->
            <!--<title>All Unit Test Packages</title>-->
            <!--<xsl:call-template name="create.stylesheet.link">-->
                <!--<xsl:with-param name="package.name"/>-->
            <!--</xsl:call-template>-->
        <!--</head>-->
        <!--<body>-->
            <!--<h2><a href="overview-summary.html" target="classFrame">Home</a></h2>-->
            <!--<h2>Packages</h2>-->
            <!--<table width="100%">-->
                <!--<xsl:apply-templates select="testsuite[not(./@package = preceding-sibling::testsuite/@package)]" mode="all.packages">-->
                    <!--<xsl:sort select="@package"/>-->
                <!--</xsl:apply-templates>-->
            <!--</table>-->
        <!--</body>-->
    <!--</html>-->
<!--</xsl:template>-->

<!--<xsl:template match="testsuite" mode="all.packages">-->
    <!--<tr>-->
        <!--<td nowrap="nowrap">-->
            <!--<a href="./{translate(@package,'.','/')}/package-summary.html" target="classFrame">-->
                <!--<xsl:value-of select="@package"/>-->
                <!--<xsl:if test="@package = ''">&lt;none&gt;</xsl:if>-->
            <!--</a>-->
        <!--</td>-->
    <!--</tr>-->
<!--</xsl:template>-->


<!--<xsl:template match="testsuites" mode="overview.packages">-->
    <!--<html>-->
        <!--<head>-->
            <!--<title>Unit Test Results: Summary</title>-->
            <!--<xsl:call-template name="create.stylesheet.link">-->
                <!--<xsl:with-param name="package.name"/>-->
            <!--</xsl:call-template>-->
        <!--</head>-->
        <!--<body>-->
        <!--<xsl:attribute name="onload">open('allclasses-frame.html','classListFrame')</xsl:attribute>-->
        <!--<xsl:call-template name="pageHeader"/>-->
        <!--<h2>Summary</h2>-->
        <!--<xsl:variable name="testCount" select="sum(testsuite/@tests)"/>-->
        <!--<xsl:variable name="errorCount" select="sum(testsuite/@errors)"/>-->
        <!--<xsl:variable name="failureCount" select="sum(testsuite/@failures)"/>-->
        <!--<xsl:variable name="timeCount" select="sum(testsuite/@time)"/>-->
        <!--<xsl:variable name="successRate" select="($testCount - $failureCount - $errorCount) div $testCount"/>-->
        <!--<table class="details" border="0" cellpadding="5" cellspacing="2" width="95%">-->
        <!--<tr valign="top">-->
            <!--<th>Tests</th>-->
            <!--<th>Failures</th>-->
            <!--<th>Errors</th>-->
            <!--<th>Success rate</th>-->
            <!--<th>Time</th>-->
        <!--</tr>-->
        <!--<tr valign="top">-->
            <!--<xsl:attribute name="class">-->
                <!--<xsl:choose>-->
                    <!--<xsl:when test="$errorCount &gt; 0">Error</xsl:when>-->
                    <!--<xsl:when test="$failureCount &gt; 0">Failure</xsl:when>-->
                    <!--<xsl:otherwise>Pass</xsl:otherwise>-->
                <!--</xsl:choose>-->
            <!--</xsl:attribute>-->
            <!--<td><xsl:value-of select="$testCount"/></td>-->
            <!--<td><xsl:value-of select="$failureCount"/></td>-->
            <!--<td><xsl:value-of select="$errorCount"/></td>-->
            <!--<td>-->
                <!--<xsl:call-template name="display-percent">-->
                    <!--<xsl:with-param name="value" select="$successRate"/>-->
                <!--</xsl:call-template>-->
            <!--</td>-->
            <!--<td>-->
                <!--<xsl:call-template name="display-time">-->
                    <!--<xsl:with-param name="value" select="$timeCount"/>-->
                <!--</xsl:call-template>-->
            <!--</td>-->

        <!--</tr>-->
        <!--</table>-->
        <!--<table border="0" width="95%">-->
        <!--<tr>-->
        <!--<td style="text-align: justify;">-->
        <!--Note: <em>failures</em> are anticipated and checked for with assertions while <em>errors</em> are unanticipated.-->
        <!--</td>-->
        <!--</tr>-->
        <!--</table>-->

        <!--<h2>Packages</h2>-->
        <!--<table class="details" border="0" cellpadding="5" cellspacing="2" width="95%">-->
            <!--<xsl:call-template name="testsuite.test.header"/>-->
            <!--<xsl:for-each select="testsuite[not(./@package = preceding-sibling::testsuite/@package)]">-->
                <!--<xsl:sort select="@package" order="ascending"/>-->
                <!--&lt;!&ndash; get the node set containing all testsuites that have the same package &ndash;&gt;-->
                <!--<xsl:variable name="insamepackage" select="/testsuites/testsuite[./@package = current()/@package]"/>-->
                <!--<tr valign="top">-->
                    <!--&lt;!&ndash; display a failure if there is any failure/error in the package &ndash;&gt;-->
                    <!--<xsl:attribute name="class">-->
                        <!--<xsl:choose>-->
                            <!--<xsl:when test="sum($insamepackage/@errors) &gt; 0">Error</xsl:when>-->
                            <!--<xsl:when test="sum($insamepackage/@failures) &gt; 0">Failure</xsl:when>-->
                            <!--<xsl:otherwise>Pass</xsl:otherwise>-->
                        <!--</xsl:choose>-->
                    <!--</xsl:attribute>-->
                    <!--<td><a href="./{translate(@package,'.','/')}/package-summary.html">-->
                        <!--<xsl:value-of select="@package"/>-->
                        <!--<xsl:if test="@package = ''">&lt;none&gt;</xsl:if>-->
                    <!--</a></td>-->
                    <!--<td><xsl:value-of select="sum($insamepackage/@tests)"/></td>-->
                    <!--<td><xsl:value-of select="sum($insamepackage/@errors)"/></td>-->
                    <!--<td><xsl:value-of select="sum($insamepackage/@failures)"/></td>-->
                    <!--<td>-->
                    <!--<xsl:call-template name="display-time">-->
                        <!--<xsl:with-param name="value" select="sum($insamepackage/@time)"/>-->
                    <!--</xsl:call-template>-->
                    <!--</td>-->
                <!--</tr>-->
            <!--</xsl:for-each>-->
        <!--</table>-->
        <!--</body>-->
        <!--</html>-->
<!--</xsl:template>-->


<!--<xsl:template name="package.summary">-->
    <!--<xsl:param name="name"/>-->
    <!--<html>-->
        <!--<head>-->
            <!--<xsl:call-template name="create.stylesheet.link">-->
                <!--<xsl:with-param name="package.name" select="$name"/>-->
            <!--</xsl:call-template>-->
        <!--</head>-->
        <!--<body>-->
            <!--<xsl:attribute name="onload">open('package-frame.html','classListFrame')</xsl:attribute>-->
            <!--<xsl:call-template name="pageHeader"/>-->
            <!--<h3>Package <xsl:value-of select="$name"/></h3>-->

            <!--&lt;!&ndash;table border="0" cellpadding="5" cellspacing="2" width="95%">-->
                <!--<xsl:call-template name="class.metrics.header"/>-->
                <!--<xsl:apply-templates select="." mode="print.metrics"/>-->
            <!--</table&ndash;&gt;-->

            <!--<xsl:variable name="insamepackage" select="/testsuites/testsuite[./@package = $name]"/>-->
            <!--<xsl:if test="count($insamepackage) &gt; 0">-->
                <!--<h2>Classes</h2>-->
                <!--<p>-->
                <!--<table class="details" border="0" cellpadding="5" cellspacing="2" width="95%">-->
                    <!--<xsl:call-template name="testsuite.test.header"/>-->
                    <!--<xsl:apply-templates select="$insamepackage" mode="print.test">-->
                        <!--<xsl:sort select="@name"/>-->
                    <!--</xsl:apply-templates>-->
                <!--</table>-->
                <!--</p>-->
            <!--</xsl:if>-->
        <!--</body>-->
    <!--</html>-->
<!--</xsl:template>-->


<!--&lt;!&ndash;-->
    <!--transform string like a.b.c to ../../../-->
    <!--@param path the path to transform into a descending directory path-->
<!--&ndash;&gt;-->
<!--<xsl:template name="path">-->
    <!--<xsl:param name="path"/>-->
    <!--<xsl:if test="contains($path,'.')">-->
        <!--<xsl:text>../</xsl:text>-->
        <!--<xsl:call-template name="path">-->
            <!--<xsl:with-param name="path"><xsl:value-of select="substring-after($path,'.')"/></xsl:with-param>-->
        <!--</xsl:call-template>-->
    <!--</xsl:if>-->
    <!--<xsl:if test="not(contains($path,'.')) and not($path = '')">-->
        <!--<xsl:text>../</xsl:text>-->
    <!--</xsl:if>-->
<!--</xsl:template>-->


<!--&lt;!&ndash; create the link to the stylesheet based on the package name &ndash;&gt;-->
<!--<xsl:template name="create.stylesheet.link">-->
    <!--<xsl:param name="package.name"/>-->
    <!--<link rel="stylesheet" type="text/css" title="Style"><xsl:attribute name="href"><xsl:if test="not($package.name = 'unnamed package')"><xsl:call-template name="path"><xsl:with-param name="path" select="$package.name"/></xsl:call-template></xsl:if>stylesheet.css</xsl:attribute></link>-->
<!--</xsl:template>-->


<!--&lt;!&ndash; Page HEADER &ndash;&gt;-->
<!--<xsl:template name="pageHeader">-->
    <!--<h1>Unit Test Results</h1>-->
    <!--<table width="100%">-->
    <!--<tr>-->
        <!--<td align="left"></td>-->
        <!--<td align="right">Designed for use with <a href="http://www.junit.org/">JUnit</a> and <a href="http://jakarta.apache.org/">Ant</a>.</td>-->
    <!--</tr>-->
    <!--</table>-->
    <!--<hr size="1"/>-->
<!--</xsl:template>-->

<!--&lt;!&ndash; class header &ndash;&gt;-->
<!--<xsl:template name="testsuite.test.header">-->
    <!--<tr valign="top">-->
        <!--<th width="80%">Name</th>-->
        <!--<th>Tests</th>-->
        <!--<th>Errors</th>-->
        <!--<th>Failures</th>-->
        <!--<th nowrap="nowrap">Time(s)</th>-->
    <!--</tr>-->
<!--</xsl:template>-->

<!--&lt;!&ndash; method header &ndash;&gt;-->
<!--<xsl:template name="testcase.test.header">-->
    <!--<tr valign="top">-->
        <!--<th>Name</th>-->
        <!--<th>Status</th>-->
        <!--<th width="80%">Type</th>-->
        <!--<th nowrap="nowrap">Time(s)</th>-->
        <!--<th>Screenshot</th>-->
    <!--</tr>-->
<!--</xsl:template>-->


<!--&lt;!&ndash; class information &ndash;&gt;-->
<!--<xsl:template match="testsuite" mode="print.test">-->
    <!--<tr valign="top">-->
        <!--<xsl:attribute name="class">-->
            <!--<xsl:choose>-->
                <!--<xsl:when test="@errors[.&gt; 0]">Error</xsl:when>-->
                <!--<xsl:when test="@failures[.&gt; 0]">Failure</xsl:when>-->
                <!--<xsl:otherwise>Pass</xsl:otherwise>-->
            <!--</xsl:choose>-->
        <!--</xsl:attribute>-->
        <!--<td><a href="{@name}.html"><xsl:value-of select="@name"/></a></td>-->
        <!--<td><xsl:apply-templates select="@tests"/></td>-->
        <!--<td><xsl:apply-templates select="@errors"/></td>-->
        <!--<td><xsl:apply-templates select="@failures"/></td>-->
        <!--<td><xsl:call-template name="display-time">-->
                <!--<xsl:with-param name="value" select="@time"/>-->
            <!--</xsl:call-template>-->
        <!--</td>-->
    <!--</tr>-->
<!--</xsl:template>-->

<!--<xsl:template match="testcase" mode="print.test">-->
    <!--<tr valign="top">-->
        <!--<xsl:attribute name="class">-->
            <!--<xsl:choose>-->
                <!--<xsl:when test="error">Error</xsl:when>-->
                <!--<xsl:when test="failure">Failure</xsl:when>-->
                <!--<xsl:otherwise>TableRowColor</xsl:otherwise>-->
            <!--</xsl:choose>-->
        <!--</xsl:attribute>-->
        <!--<td><xsl:value-of select="@name"/></td>-->
        <!--<xsl:choose>-->
            <!--<xsl:when test="failure">-->
                <!--<td>Failure</td>-->
                <!--<td><xsl:apply-templates select="failure"/></td>-->
            <!--</xsl:when>-->
            <!--<xsl:when test="error">-->
                <!--<td>Error</td>-->
                <!--<td><xsl:apply-templates select="error"/></td>-->
            <!--</xsl:when>-->
            <!--<xsl:otherwise>-->
                <!--<td>Success</td>-->
                <!--<td></td>-->
            <!--</xsl:otherwise>-->
        <!--</xsl:choose>-->
        <!--<td>-->
            <!--<xsl:call-template name="display-time">-->
                <!--<xsl:with-param name="value" select="@time"/>-->
            <!--</xsl:call-template>-->
        <!--</td>-->
        <!--<xsl:choose>-->
            <!--<xsl:when test="failure">-->
                <!--<td><a href="../../../../../screenshots/{@name}.png" target="_blank">screenshot</a>-->
                <!--</td>-->
            <!--</xsl:when>-->
            <!--<xsl:when test="error">-->
                <!--<td><a href="../../../../../screenshots/{@name}.png" target="_blank">screenshot</a>-->
                <!--</td>-->
            <!--</xsl:when>-->
            <!--<xsl:otherwise>-->
                <!--<td></td>-->
            <!--</xsl:otherwise>-->
        <!--</xsl:choose>-->
    <!--</tr>-->
<!--</xsl:template>-->


<!--&lt;!&ndash; Note : the below template error and failure are the same style-->
            <!--so just call the same style store in the toolkit template &ndash;&gt;-->
<!--<xsl:template match="failure">-->
    <!--<xsl:call-template name="display-failures"/>-->
<!--</xsl:template>-->

<!--<xsl:template match="error">-->
    <!--<xsl:call-template name="display-failures"/>-->
<!--</xsl:template>-->

<!--&lt;!&ndash; Style for the error and failure in the testcase template &ndash;&gt;-->
<!--<xsl:template name="display-failures">-->
    <!--<xsl:choose>-->
        <!--<xsl:when test="not(@message)">N/A</xsl:when>-->
        <!--<xsl:otherwise>-->
            <!--<xsl:value-of select="@message"/>-->
        <!--</xsl:otherwise>-->
    <!--</xsl:choose>-->
    <!--&lt;!&ndash; display the stacktrace &ndash;&gt;-->
    <!--<br/><br/>-->
    <!--<code>-->
        <!--<xsl:call-template name="br-replace">-->
            <!--<xsl:with-param name="word" select="."/>-->
        <!--</xsl:call-template>-->
    <!--</code>-->
    <!--&lt;!&ndash; the latter is better but might be problematic for non-21" monitors... &ndash;&gt;-->
    <!--&lt;!&ndash;pre><xsl:value-of select="."/></pre&ndash;&gt;-->
<!--</xsl:template>-->

<!--<xsl:template name="JS-escape">-->
    <!--<xsl:param name="string"/>-->
    <!--<xsl:param name="tmp1" select="stringutils:replace(string($string),'\','\\')"/>-->
    <!--<xsl:param name="tmp2" select="stringutils:replace(string($tmp1),&quot;'&quot;,&quot;\&apos;&quot;)"/>-->
    <!--<xsl:value-of select="$tmp2"/>-->
<!--</xsl:template>-->

<!--&lt;!&ndash;-->
    <!--template that will convert a carriage return into a br tag-->
    <!--@param word the text from which to convert CR to BR tag-->
<!--&ndash;&gt;-->
<!--<xsl:template name="br-replace">-->
    <!--<xsl:param name="word"/>-->
    <!--<xsl:choose>-->
        <!--<xsl:when test="contains($word,'&#xA;')">-->
            <!--<xsl:value-of select="substring-before($word,'&#xA;')"/>-->
            <!--<br/>-->
            <!--<xsl:call-template name="br-replace">-->
                <!--<xsl:with-param name="word" select="substring-after($word,'&#xA;')"/>-->
            <!--</xsl:call-template>-->
        <!--</xsl:when>-->
        <!--<xsl:otherwise>-->
            <!--<xsl:value-of select="$word"/>-->
        <!--</xsl:otherwise>-->
    <!--</xsl:choose>-->
<!--</xsl:template>-->

<!--<xsl:template name="display-time">-->
    <!--<xsl:param name="value"/>-->
    <!--<xsl:value-of select="format-number($value,'0.000')"/>-->
<!--</xsl:template>-->

<!--<xsl:template name="display-percent">-->
    <!--<xsl:param name="value"/>-->
    <!--<xsl:value-of select="format-number($value,'0.00%')"/>-->
<!--</xsl:template>-->
<!--</xsl:stylesheet>-->

