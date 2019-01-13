Ext.define('gantang.mstdata.vehiclematerial.VehicleMaterialModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'materialCode',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'featureCodes',
			type : 'string'
		},{
		name : 'featureNames',
			type : 'string'
		},{
		name : 'businessScope',
			type : 'string'
		},{
		name : 'isSaleAvailable',
			type : 'boolean'
		},{
		name : 'productNodeId',
			type : 'number'
		},{
		name : 'vehicleMaterialExtId',
			type : 'number'
		},{
		name : 'parentProductNodeId',
			type : 'number'
		},{
	}]
});