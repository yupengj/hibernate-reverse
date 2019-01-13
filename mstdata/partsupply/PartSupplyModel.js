Ext.define('gantang.mstdata.partsupply.PartSupplyModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'supplyType',
			type : 'string'
		},{
		name : 'vendorPartNum',
			type : 'string'
		},{
		name : 'ratio',
			type : 'number'
		},{
		name : 'isFrozen',
			type : 'boolean'
		},{
		name : 'nominatePrice',
			type : 'number'
		},{
		name : 'supplyFrom',
			type : 'date'
		},{
		name : 'supplyTo',
			type : 'date'
		},{
		name : 'partId',
			type : 'number'
		},{
		name : 'supplierId',
			type : 'number'
		},{
		name : 'plantId',
			type : 'number'
		},{
		name : 'partSupplyExtId',
			type : 'number'
		},{
		name : 'buyerId',
			type : 'number'
		},{
	}]
});