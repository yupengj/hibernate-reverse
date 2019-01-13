Ext.define('gantang.mstdata.feature.FeatureModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'featureCode',
			type : 'string'
		},{
		name : 'featureName',
			type : 'string'
		},{
		name : 'featureDesc',
			type : 'string'
		},{
		name : 'isForced',
			type : 'boolean'
		},{
		name : 'featureCategory',
			type : 'string'
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
		name : 'salesGroup',
			type : 'string'
		},{
		name : 'path',
			type : 'string'
		},{
		name : 'scope',
			type : 'string'
		},{
		name : 'operationType',
			type : 'string'
		},{
		name : 'simpleCode',
			type : 'string'
		},{
		name : 'isOptional',
			type : 'boolean'
		},{
		name : 'pictureId',
			type : 'number'
		},{
		name : 'parentId',
			type : 'number'
		},{
		name : 'featureExtId',
			type : 'number'
		},{
		name : 'businessScope',
			type : 'string'
		},{
		name : 'manufactureGroup',
			type : 'string'
		},{
		name : 'engineeringGroup',
			type : 'string'
		},{
		name : 'featureContent',
			type : 'string'
		},{
	}]
});