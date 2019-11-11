<?xml version="1.0" encoding="UTF-8"?>

<!-- transform & stylesheets are synonyms -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    
    <!-- possible values are text, xml, html -->
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Lekari.xsl</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Ime</td>
                        <td>Prezime</td>
                        <td>Oblast</td>
                    </tr>
                    <xsl:for-each select="//lekar">
                        <tr>
                            <td>
                                <!--doesn't have to have attribute, will work without it-->
                                <xsl:apply-templates select="./@id"></xsl:apply-templates>
                            </td>
                            <td>
                                <xsl:apply-templates select="./ime"></xsl:apply-templates>
                            </td>
                            <td>
                                <xsl:apply-templates select="./prezime"></xsl:apply-templates>
                            </td>
                            <td>
                                <xsl:apply-templates select="./oblast"></xsl:apply-templates>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>