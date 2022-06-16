# querydsl-sample-project
QueryDSL 실습 프로젝트 DB 정보  

## 개요
> - DB
> - ERD
> - 테이블 생성 DDL  

### DB
> - MySQL  

### ERD
> - le_order_option  
> ![le_order_option ERD](https://github.com/primarchan/querydsl-sample-project/blob/main/images/le_order_option%20ERD.PNG "le_order_option ERD")  
> - le_order_option_history  
> ![le_order_option_history ERD](https://github.com/primarchan/querydsl-sample-project/blob/main/images/le_order_option_history%20ERD.PNG "le_order_option_history ERD")

### 테이블 생성 DDL
> - le_order_option  
```SQL
CREATE TABLE `le_order_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `cancel_fail_message` varchar(255) DEFAULT NULL,
  `canceled_date` datetime DEFAULT NULL,
  `consumed_date` datetime DEFAULT NULL,
  `cost_price` decimal(19,0) DEFAULT NULL,
  `cover_price` decimal(19,0) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `forced_order_fail_code` varchar(255) DEFAULT NULL,
  `option_id` bigint(20) NOT NULL,
  `option_name` varchar(255) DEFAULT NULL,
  `order_cancel_fail_code` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `refund_type` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `sale_price` decimal(19,0) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `yan_ordered_option_id` bigint(20) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `cancel_reason` varchar(255) DEFAULT NULL,
  `charged_name` varchar(255) DEFAULT NULL,
  `order_fail_code` varchar(255) DEFAULT NULL,
  `channel` varchar(255) DEFAULT NULL,
  `channel_discount_amount` decimal(19,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9lgvfsiqxt9f62g9dn7ldswlg` (`order_id`),
  CONSTRAINT `FK9lgvfsiqxt9f62g9dn7ldswlg` FOREIGN KEY (`order_id`) REFERENCES `le_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4014 DEFAULT CHARSET=utf8mb4;
```  
> - le_order_option_history  
```SQL
CREATE TABLE `le_order_option_history` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `cancel_fail_message` varchar(255) DEFAULT NULL,
  `canceled_date` datetime DEFAULT NULL,
  `consumed_date` datetime DEFAULT NULL,
  `cost_price` decimal(19,0) DEFAULT NULL,
  `cover_price` decimal(19,0) DEFAULT NULL,
  `expired_date` date DEFAULT NULL,
  `forced_order_fail_code` varchar(255) DEFAULT NULL,
  `option_id` bigint(20) NOT NULL,
  `option_name` varchar(255) DEFAULT NULL,
  `order_cancel_fail_code` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `refund_type` varchar(255) DEFAULT NULL,
  `restored_date` datetime DEFAULT NULL,
  `sale_price` decimal(19,0) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `yan_ordered_option_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `cancel_reason` varchar(255) DEFAULT NULL,
  `charged_name` varchar(255) DEFAULT NULL,
  `order_fail_code` varchar(255) DEFAULT NULL,
  `channel` varchar(255) DEFAULT NULL,
  `paid_price` decimal(19,0) DEFAULT NULL,
  `channel_discount_amount` decimal(19,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh2xcnhe8op0wim26eimm5u789` (`order_id`),
  CONSTRAINT `FKh2xcnhe8op0wim26eimm5u789` FOREIGN KEY (`order_id`) REFERENCES `le_order_history` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
