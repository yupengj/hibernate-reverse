Ext.define('gantang.mstdata.supplier.SupplierModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'supplierCode',
			type : 'string'
		},{
		name : 'supplierName',
			type : 'string'
		},{
		name : 'supplierNameEn',
			type : 'string'
		},{
		name : 'taxCode',
			type : 'string'
		},{
		name : 'legalPerson',
			type : 'string'
		},{
		name : 'supplierGrade',
			type : 'string'
		},{
		name : 'primaryProduct',
			type : 'string'
		},{
		name : 'isPotentialSupplier',
			type : 'boolean'
		},{
		name : 'supplierType',
			type : 'string'
		},{
		name : 'currency',
			type : 'string'
		},{
		name : 'sapCode',
			type : 'string'
		},{
		name : 'accountGroup',
			type : 'string'
		},{
		name : 'tradePartner',
			type : 'string'
		},{
		name : 'isProduction',
			type : 'boolean'
		},{
		name : 'supplyStatus',
			type : 'string'
		},{
		name : 'organizationId',
			type : 'number'
		},{
		name : 'addressId',
			type : 'number'
		},{
		name : 'supplierExtId',
			type : 'number'
		},{
		name : 'isLatest',
			type : 'boolean'
		},{
		name : 'mdSettlementBankId',
			type : 'number'
		},{
		name : 'parentSupplierId',
			type : 'number'
		},{
		name : 'legalPersonEffectiveTo',
			type : 'date'
		},{
		name : 'paymentTerm',
			type : 'string'
		},{
	}]
});