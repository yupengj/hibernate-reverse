Ext.define('gantang.mstdata.partdesc.PartDescModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'structureShortCode',
			type : 'string'
		},{
		name : 'positionCode',
			type : 'string'
		},{
		name : 'partDescZh',
			type : 'string'
		},{
		name : 'partDescEn',
			type : 'string'
		},{
		name : 'isEffective',
			type : 'boolean'
		},{
		name : 'effectiveFrom',
			type : 'date'
		},{
		name : 'effectiveTo',
			type : 'date'
		},{
		name : 'partDescExtId',
			type : 'number'
		},{
		name : 'structureCode',
			type : 'string'
		},{
	}]
});