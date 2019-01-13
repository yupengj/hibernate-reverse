Ext.define('gantang.mstdata.propertiesdefine.PropertiesDefineModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'className',
			type : 'string'
		},{
		name : 'columnName',
			type : 'string'
		},{
		name : 'displayName',
			type : 'string'
		},{
		name : 'columnType',
			type : 'string'
		},{
		name : 'columnConfigOptions',
			type : 'string'
		},{
		name : 'emptyText',
			type : 'string'
		},{
		name : 'columnOrder',
			type : 'number'
		},{
		name : 'status',
			type : 'string'
		},{
	}]
});