Ext.define('gantang.mstdata.partcost.PartCostModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'expectedCost',
			type : 'number'
		},{
		name : 'targetCost',
			type : 'number'
		},{
		name : 'actualCost',
			type : 'number'
		},{
		name : 'costUnit',
			type : 'string'
		},{
		name : 'partId',
			type : 'number'
		},{
	}]
});