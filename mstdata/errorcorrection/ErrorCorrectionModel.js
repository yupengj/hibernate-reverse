Ext.define('gantang.mstdata.errorcorrection.ErrorCorrectionModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'recTypeId',
			type : 'number'
		},{
		name : 'recId',
			type : 'number'
		},{
		name : 'certificate',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
	}]
});