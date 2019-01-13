Ext.define('gantang.mstdata.partservice.PartServiceModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'partServiceExtId',
			type : 'number'
		},{
		name : 'isRepare',
			type : 'boolean'
		},{
		name : 'nonRepareReason',
			type : 'string'
		},{
		name : 'isColorRepare',
			type : 'boolean'
		},{
		name : 'isPrimerRepare',
			type : 'boolean'
		},{
		name : 'isElectrophoresisRepare',
			type : 'boolean'
		},{
		name : 'electrophoresisArea',
			type : 'number'
		},{
		name : 'note',
			type : 'string'
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
		name : 'preVersionId',
			type : 'number'
		},{
		name : 'versionNo',
			type : 'number'
		},{
		name : 'partId',
			type : 'number'
		},{
		name : 'productionPartId',
			type : 'number'
		},{
		name : 'changeId',
			type : 'number'
		},{
	}]
});