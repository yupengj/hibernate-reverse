Ext.define('gantang.mstdata.material.MaterialModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'isServicePart',
			type : 'boolean'
		},{
		name : 'controllerIdentify',
			type : 'string'
		},{
		name : 'ecuTypeId',
			type : 'number'
		},{
		name : 'isServicePublished',
			type : 'boolean'
		},{
		name : 'referenceCostPartId',
			type : 'number'
		},{
		name : 'referencePrice',
			type : 'number'
		},{
		name : 'costEngineerId',
			type : 'number'
		},{
		name : 'discriminator',
			type : 'boolean'
		},{
		name : 'materialNum',
			type : 'string'
		},{
		name : 'materialName',
			type : 'string'
		},{
		name : 'materialNameEn',
			type : 'string'
		},{
		name : 'measurementUnit',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'employeeId',
			type : 'number'
		},{
		name : 'isProduct',
			type : 'boolean'
		},{
		name : 'isPart',
			type : 'boolean'
		},{
		name : 'lifeCycleState',
			type : 'string'
		},{
		name : 'isNaturalColor',
			type : 'boolean'
		},{
		name : 'isTemporary',
			type : 'boolean'
		},{
		name : 'isEngineerPublished',
			type : 'boolean'
		},{
		name : 'ieIdentifyCode',
			type : 'string'
		},{
		name : 'colorCode',
			type : 'string'
		},{
		name : 'pictureId',
			type : 'number'
		},{
		name : 'oldMaterialNum',
			type : 'string'
		},{
		name : 'partTypeId',
			type : 'number'
		},{
		name : 'naturalColorPartId',
			type : 'number'
		},{
		name : 'materialGroupId',
			type : 'number'
		},{
		name : 'engineerCenterId',
			type : 'number'
		},{
		name : 'partExtId',
			type : 'number'
		},{
	}]
});