Ext.define('gantang.mstdata.productstructure.ProductStructureModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'hierarchyLevel',
			type : 'number'
		},{
		name : 'structureCode',
			type : 'string'
		},{
		name : 'structureShortCode',
			type : 'string'
		},{
		name : 'simpleCode',
			type : 'string'
		},{
		name : 'zhDesc',
			type : 'string'
		},{
		name : 'enDesc',
			type : 'string'
		},{
		name : 'remark',
			type : 'string'
		},{
		name : 'version',
			type : 'number'
		},{
		name : 'status',
			type : 'string'
		},{
		name : 'effectiveFrom',
			type : 'date'
		},{
		name : 'effectiveTo',
			type : 'date'
		},{
		name : 'path',
			type : 'string'
		},{
		name : 'isNecessary',
			type : 'boolean'
		},{
		name : 'parentId',
			type : 'number'
		},{
		name : 'sonId',
			type : 'number'
		},{
		name : 'productStructureExtId',
			type : 'number'
		},{
	}]
});