Ext.define('gantang.mstdata.producttype.ProductTypeModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'typeCode',
			type : 'string'
		},{
		name : 'typeName',
			type : 'string'
		},{
		name : 'path',
			type : 'string'
		},{
		name : 'parentId',
			type : 'number'
		},{
		name : 'productTypeExtId',
			type : 'number'
		},{
	}]
});