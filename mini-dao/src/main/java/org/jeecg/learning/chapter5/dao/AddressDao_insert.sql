insert
into
tbl_address
      (id,street,city,country, customer_id)
values
      ('${address.id}',
       :address.street,
       :address.city,
       :address.country,
       '${address.customer.id}'
      )