<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output cdata-section-elements="foo"/>
  <xsl:template match="/">
    <foo>
      <xsl:value-of select="node"/>
    </foo>
  </xsl:template>
</xsl:stylesheet>
