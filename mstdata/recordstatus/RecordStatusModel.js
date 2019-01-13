Ext.define('gantang.mstdata.recordstatus.RecordStatusModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'recTypeId',
			type : 'number'
		},{
		name : 'recId',
			type : 'number'
		},{
		name : 'changeCode',
			type : 'string'
		},{
		name : 'status',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'effectiveFrom',
			type : 'date'
		},{
		name : 'effectiveTo',
			type : 'date'
		},{
		name : 'recordStatusExtId',
			type : 'number'
		},{
		name : 'plantId',
			type : 'number'
		},{
	}]
});