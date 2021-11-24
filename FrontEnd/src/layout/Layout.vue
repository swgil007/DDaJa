<template>
    <div>
        <h1> layout </h1>
        <header />
        <slot />
        <footer />
        <h1> layout Foot </h1>
    </div>
</template>

<script>
import Header from './components/Header'
import Footer from './components/Footer'

export default {
    name: 'Layout',
    components: {
        Header,
        Footer,
    }
}
</script>