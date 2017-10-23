<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes" encoding="UTF-8"/>

	<xsl:template match="teaserText_fr">
		<xsl:copy>
			<xsl:text disable-output-escaping="yes">&lt;![CDATA[</xsl:text>
			<xsl:copy-of select="*"/>    
			<xsl:text disable-output-escaping="yes">]]&gt;</xsl:text>
		</xsl:copy>
	</xsl:template>
	
</xsl:stylesheet>