
select   
*
from 
tc_coupon_get c,
ebf_write_off_personnel p,
ebf_user_base em  
,ebf_brand_store bs
where 
 c.emp_user_id = em.user_id 
,c.emp_user_identity = em.card 
,c.emp_user_name = em.user_name
,c.used_bstore_id = p.brand_store_id
,c.used_bstore_name = bs.brand_store_name
,c.emp_type =0 ;


-----------------------------------------------------
update  
tc_coupon_get c,
ebf_write_off_personnel p,
ebf_user_base em  
,ebf_brand_store bs
set 
 c.emp_user_id = em.user_id 
,c.emp_user_identity = em.card 
,c.emp_user_name = em.user_name
,c.used_bstore_id = p.brand_store_id
,c.used_bstore_name = bs.brand_store_name
,c.emp_type =0
 
where c.write_off_id = p.write_off_id and p.write_off_phone = em.phone
and bs.brand_store_id = p.brand_store_id 
