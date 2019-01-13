Ext.define('gantang.mstdata.partnumrequestlist.PartnumRequestListModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'materialNum',
			type : 'string'
		},{
		name : 'oldMaterialNum',
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
		name : 'isNaturalColor',
			type : 'boolean'
		},{
		name : 'ieIdentifyCode',
			type : 'string'
		},{
		name : 'confirmTag',
			type : 'boolean'
		},{
		name : 'isTemproryTurn',
			type : 'boolean'
		},{
		name : 'partnumApplyFormId',
			type : 'number'
		},{
		name : 'temproryPartId',
			type : 'number'
		},{
		name : 'engineerCenterId',
			type : 'number'
		},{
		name : 'partnumRequestListExtId',
			type : 'number'
		},{
		name : 'partTypeId',
			type : 'number'
		},{
		name : 'isServicePart',
			type : 'boolean'
		},{
		name : 'inheritMsg',
			type : 'string'
		},{
		name : 'controllerIdentify',
			type : 'string'
		},{
		name : 'ecuTypeId',
			type : 'number'
		},{
		name : 'colorCode',
			type : 'string'
		},{
		name : 'productCodes',
			type : 'string'
		},{
		name : 'vehicleCodes',
			type : 'string'
		},{
	}]
});