Ext.define('gantang.mstdata.partdesign.PartDesignModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'drawingNo',
			type : 'string'
		},{
		name : 'drawingVersion',
			type : 'string'
		},{
		name : 'drawingStatus',
			type : 'string'
		},{
		name : 'drawingDate',
			type : 'date'
		},{
		name : 'drawingPath',
			type : 'string'
		},{
		name : 'digifaxNo',
			type : 'string'
		},{
		name : 'digifaxVersion',
			type : 'string'
		},{
		name : 'digifaxStatus',
			type : 'string'
		},{
		name : 'digifaxDate',
			type : 'date'
		},{
		name : 'digifaxPath',
			type : 'string'
		},{
		name : 'shapeSize',
			type : 'string'
		},{
		name : 'sizeUnit',
			type : 'string'
		},{
		name : 'materialName',
			type : 'string'
		},{
		name : 'materialClass',
			type : 'string'
		},{
		name : 'materialCode',
			type : 'string'
		},{
		name : 'materialThick',
			type : 'string'
		},{
		name : 'isSafetyPart',
			type : 'boolean'
		},{
		name : 'isSymmetryPart',
			type : 'boolean'
		},{
		name : 'weightUnit',
			type : 'string'
		},{
		name : 'targetWeight',
			type : 'number'
		},{
		name : 'expectedWeight',
			type : 'number'
		},{
		name : 'calculatedWeight',
			type : 'number'
		},{
		name : 'actualWeight',
			type : 'number'
		},{
		name : 'currentWeight',
			type : 'number'
		},{
		name : 'activeStatus',
			type : 'string'
		},{
		name : 'effectiveFrom',
			type : 'date'
		},{
		name : 'effectiveTo',
			type : 'date'
		},{
		name : 'isLatest',
			type : 'boolean'
		},{
		name : 'partId',
			type : 'number'
		},{
		name : 'preVersionId',
			type : 'number'
		},{
		name : 'changeId',
			type : 'number'
		},{
		name : 'partDesignExtId',
			type : 'number'
		},{
		name : 'suggestSourcing',
			type : 'string'
		},{
		name : 'discriminator',
			type : 'string'
		},{
		name : 'plantId',
			type : 'number'
		},{
		name : 'receivedVersionNo',
			type : 'number'
		},{
		name : 'versionNo',
			type : 'number'
		},{
	}]
});