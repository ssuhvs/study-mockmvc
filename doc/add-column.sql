 -- 优惠券领取记录表 20190508
 ALTER TABLE  tc_coupon_get add `emp_user_id` bigint(11) DEFAULT NULL COMMENT '核销人ID,雇员在扫码核销时获到其ebf_user_base表中的主键';
 ALTER TABLE  tc_coupon_get add `emp_user_identity` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '核销人员卡号，不会变，冗余设计';
 ALTER TABLE  tc_coupon_get add `emp_type` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '核销操作类型，0 默认白名单用户操作，1 门店账号用户操作';
 ALTER TABLE  tc_coupon_get add `emp_user_name` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '核销人员姓名，冗余设计';
 ALTER TABLE  tc_coupon_get add `used_bstore_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最终消费在哪个品牌店（历史名称）' ;
 ALTER TABLE  tc_coupon_get add `used_bstore_id` bigint(11) DEFAULT NULL COMMENT '最终消费在哪个品牌店id';