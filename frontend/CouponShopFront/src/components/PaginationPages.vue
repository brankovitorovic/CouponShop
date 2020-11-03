<template>
  <div v-if=" paginationInfo.totalPages > 0" id = "paginationPage">
    <span v-if="showPreviousLink()" class="pagination-btn" v-on:click="previousPage()">  &lt; </span>
    {{ paginationInfo.currentPage + 1 }} of {{ paginationInfo.totalPages }}
    <span v-if="showNextLink()" class="pagination-btn" v-on:click="nextPage()" > > </span>

  </div>
</template>

<script>

export default {
name: "paginationPages",
	props: ["paginationInfo"],

	methods: {
	
	showPreviousLink() {
      return this.paginationInfo.currentPage == 0 ? false : true;
    },
    showNextLink() {
      return this.paginationInfo.currentPage == (this.paginationInfo.totalPages - 1) ? false : true;
	},
	previousPage(){
		this.$emit("previous-page",this.paginationInfo.currentPage - 1);
	},
	nextPage(){
		this.$emit("next-page",this.paginationInfo.currentPage + 1);
	}
	},

}

</script>

<style>


.pagination-btn {
  cursor: pointer;
}

</style>