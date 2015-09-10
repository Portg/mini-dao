SELECT * FROM tbl_address
WHERE 1 = 1
<#if street ?exists>
	and street = :street
</#if>
<#if city ?exists>
	and city = :city
</#if>
<#if country ?exists>
	and country = :country
</#if>