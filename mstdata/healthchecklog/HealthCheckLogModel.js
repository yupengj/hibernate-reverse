Ext.define('gantang.mstdata.healthchecklog.HealthCheckLogModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'healthCheckNo',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'status',
			type : 'string'
		},{
		name : 'checkedDate',
			type : 'date'
		},{
		name : 'fileId',
			type : 'number'
		},{
		name : 'checkedBy',
			type : 'number'
		},{
		name : 'isOpen',
			type : 'boolean'
		},{
	}]
});