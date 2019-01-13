Ext.define('gantang.mstdata.routeline.RouteLineModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'lineCode',
			type : 'string'
		},{
		name : 'lineName',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'routeLineExtId',
			type : 'number'
		},{
	}]
});