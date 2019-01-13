Ext.define('gantang.mstdata.partrouting.PartRoutingModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'priority',
			type : 'number'
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
		name : 'plantId',
			type : 'number'
		},{
		name : 'partRoutingExtId',
			type : 'number'
		},{
		name : 'lineType',
			type : 'string'
		},{
		name : 'partId',
			type : 'number'
		},{
		name : 'lineCode',
			type : 'string'
		},{
		name : 'lineName',
			type : 'string'
		},{
		name : 'structureShortCode',
			type : 'string'
		},{
		name : 'positionCode',
			type : 'string'
		},{
		name : 'masterPartNum',
			type : 'string'
		},{
		name : 'partNumPath',
			type : 'string'
		},{
		name : 'partDesc',
			type : 'string'
		},{
	}]
});