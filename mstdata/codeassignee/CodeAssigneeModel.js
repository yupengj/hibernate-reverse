Ext.define('gantang.mstdata.codeassignee.CodeAssigneeModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'recTypeId',
			type : 'number'
		},{
		name : 'prefix',
			type : 'string'
		},{
		name : 'suffix',
			type : 'string'
		},{
		name : 'maxSequence',
			type : 'number'
		},{
		name : 'code',
			type : 'string'
		},{
		name : 'status',
			type : 'string'
		},{
		name : 'hooked',
			type : 'boolean'
		},{
	}]
});