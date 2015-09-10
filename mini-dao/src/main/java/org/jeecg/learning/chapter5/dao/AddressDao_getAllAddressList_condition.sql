<#if address.street ?exists>
	and street = :address.street
</#if>
<#if address.city ?exists>
	and city = :address.city
</#if>
<#if address.country ?exists>
	and country = :address.country
</#if>