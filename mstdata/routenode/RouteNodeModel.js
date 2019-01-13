Ext.define('gantang.mstdata.routenode.RouteNodeModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'nodeCode',
			type : 'string'
		},{
		name : 'nodeName',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'workShopId',
			type : 'number'
		},{
		name : 'routeNodeExtId',
			type : 'number'
		},{
	}]
});