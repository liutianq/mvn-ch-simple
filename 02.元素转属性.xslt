<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="sale_order">
		<sale_order>
			<item_list>
				<xsl:apply-templates/>
			</item_list>
		</sale_order>
	</xsl:template>
	<xsl:template match="item">
		<item>
			<xsl:for-each select="*[not(self::obj_list)]">
				<xsl:attribute name="{name()}"><xsl:value-of select="text()"/></xsl:attribute>
			</xsl:for-each>
			<xsl:apply-templates select="obj_list"/>
		</item>
	</xsl:template>
	<xsl:template match="obj_list">
		<obj_list>
			<xsl:apply-templates select="obj"/>
		</obj_list>
	</xsl:template>
	<xsl:template match="obj">
		<obj>
			<xsl:for-each select="*[not(self::attr_list)]">
				<xsl:attribute name="{name()}"><xsl:value-of select="text()"/></xsl:attribute>
			</xsl:for-each>
			<xsl:apply-templates select="attr_list"/>
		</obj>
	</xsl:template>
	<xsl:template match="attr_list">
		<attr_list>
			<xsl:apply-templates select="attr"/>
		</attr_list>
	</xsl:template>
	<xsl:template match="attr">
		<attr>
			<xsl:for-each select="*">
				<xsl:attribute name="{name()}"><xsl:value-of select="text()"/></xsl:attribute>
			</xsl:for-each>
		</attr>
	</xsl:template>
</xsl:stylesheet>
