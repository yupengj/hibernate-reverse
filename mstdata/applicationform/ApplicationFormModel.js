Ext.define('gantang.mstdata.applicationform.ApplicationFormModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'formCode',
			type : 'string'
		},{
		name : 'formType',
			type : 'string'
		},{
		name : 'remark',
			type : 'string'
		},{
		name : 'status',
			type : 'string'
		},{
		name : 'outerStatus',
			type : 'string'
		},{
		name : 'finishDate',
			type : 'date'
		},{
		name : 'employeeId',
			type : 'number'
		},{
		name : 'organizationId',
			type : 'string'
		},{
	}]
});