Ext.define('gantang.mstdata.ecutype.EcuTypeModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'ecuTypeCode',
			type : 'string'
		},{
		name : 'ecuTypeName',
			type : 'string'
		},{
		name : 'ecuTypeDesc',
			type : 'string'
		},{
		name : 'orderNum',
			type : 'number'
		},{
		name : 'ecuTypeExtId',
			type : 'number'
		},{
	}]
});