Ext.define('gantang.mstdata.partnumhistory.PartnumHistoryModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'sourceCode',
			type : 'string'
		},{
		name : 'changeReason',
			type : 'string'
		},{
		name : 'changeDesc',
			type : 'string'
		},{
		name : 'changeDate',
			type : 'date'
		},{
		name : 'isAutoCreate',
			type : 'boolean'
		},{
		name : 'partId',
			type : 'number'
		},{
	}]
});