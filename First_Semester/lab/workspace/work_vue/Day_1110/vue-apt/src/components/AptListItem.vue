<template>
  <tr>
    <td>{{ apt.일련번호 }}</td>
    <td>{{ apt.아파트명 }}</td>
    <td>{{ apt.법정동 }}</td>
    <td>{{ apt.층 }}층</td>
    <td>{{ apt.거래금액 }}만원</td>
  </tr>
</template>

<script>
export default {
  name: "AptListItem",
  props: {
    apt: Object,
  },
};
</script>

<style scoped>
td {
  font-weight: bold;
  border-bottom: 2px solid rgb(244, 108, 108);
}
</style>