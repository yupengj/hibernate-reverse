Ext.define('gantang.mstdata.changecontrolfields.ChangeControlFieldsModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'recTypeId',
			type : 'number'
		},{
		name : 'fieldName',
			type : 'string'
		},{
		name : 'propertyName',
			type : 'string'
		},{
	}]
});