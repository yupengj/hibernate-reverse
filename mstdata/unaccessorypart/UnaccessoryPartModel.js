Ext.define('gantang.mstdata.unaccessorypart.UnaccessoryPartModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'partId',
			type : 'number'
		},{
		name : 'productId',
			type : 'number'
		},{
		name : 'productNodeId',
			type : 'number'
		},{
	}]
});