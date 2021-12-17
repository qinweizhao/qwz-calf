<template>
  <div>
    <svg-icon icon-class="github" @click="goto"/>
  </div>
</template>

<script>
export default {
  name: 'Git',
  data() {
    return {
      url: 'https://github.com/qinweizhao/qwz-calf'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
