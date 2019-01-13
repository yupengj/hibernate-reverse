Ext.define('gantang.mstdata.productnode.ProductNodeModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'isDevPublish',
			type : 'boolean'
		},{
		name : 'nodeType',
			type : 'string'
		},{
		name : 'nodeCode',
			type : 'string'
		},{
		name : 'nodeName',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'status',
			type : 'string'
		},{
		name : 'businessLevel',
			type : 'string'
		},{
		name : 'path',
			type : 'string'
		},{
		name : 'isBomNode',
			type : 'boolean'
		},{
		name : 'isConfigNode',
			type : 'boolean'
		},{
		name : 'isForSale',
			type : 'boolean'
		},{
		name : 'mappingNodeId',
			type : 'number'
		},{
		name : 'announcementCode',
			type : 'string'
		},{
		name : 'projectCode',
			type : 'string'
		},{
		name : 'parentId',
			type : 'number'
		},{
		name : 'productTypeId',
			type : 'number'
		},{
		name : 'partId',
			type : 'number'
		},{
		name : 'companyId',
			type : 'number'
		},{
		name : 'firstPlantId',
			type : 'number'
		},{
		name : 'productNodeExtId',
			type : 'number'
		},{
	}]
});