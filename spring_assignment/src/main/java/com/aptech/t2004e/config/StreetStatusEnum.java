package com.aptech.t2004e.config;

public enum StreetStatusEnum {
			DANG_SU_DUNG("in_use"),
			DANG_THI_CONG("under_construction"),
			DANG_SUA_CHUA("under_repair");
			
			public String val;
			
			private StreetStatusEnum(String val) {
				this.val = val;
			}
}
